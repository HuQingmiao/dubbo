/*
 * Copyright (c) 2001-2004 Caucho Technology, Inc.  All rights reserved.
 *
 * The Apache Software License, Version 1.1
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Caucho Technology (http://www.caucho.com/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "Hessian", "Resin", and "Caucho" must not be used to
 *    endorse or promote products derived from this software without prior
 *    written permission. For written permission, please contact
 *    info@caucho.com.
 *
 * 5. Products derived from this software may not be called "Resin"
 *    nor may "Resin" appear in their names without prior written
 *    permission of Caucho Technology.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL CAUCHO TECHNOLOGY OR ITS CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY,
 * OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT
 * OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
 * BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN
 * IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * @author Scott Ferguson
 */

package com.alibaba.com.caucho.hessian.io;


import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Deserializing a JDK 1.2 Collection.
 */
public class CollectionDeserializer extends AbstractListDeserializer {

    //private Logger log = LoggerFactory.getLogger(this.getClass());

    private Class _type;

    public CollectionDeserializer(Class type) {
        _type = type;
    }

    public Class getType() {
        return _type;
    }

    public Object readList(AbstractHessianInput in, int length)
            throws IOException {
        Collection list = createList();

        in.addRef(list);

        /**
         * 修改序列化过程中导致属性丢失的bug：对继承自Collection并扩展了新属性的类，对其新增属性反序列化。
         *
         * Added By HuQingmiao(443770574@qq.com) on 2017-03-25.
         */
        /** begin **/
        //记录已经读过的子类属性，以防被同名父类属性覆盖
        Set<String> fieldNameSet = new HashSet<String>();
        try {
            Class clasz = list.getClass();

            // 不处理java库本身的collection类，只处理自定义的collection类
            for (; !clasz.getName().startsWith("java."); clasz = clasz.getSuperclass()) {

                /**
                 * 通常认为只有Collection的子类才会进入本类反序列化, 但是com.alibaba.fastjson.JSONArray也进入本类反序列化, 虽然它不是Collection的子类,
                 * 因此必须将其排除, 使其按照fastjson本身的机制序列化.  _2017-08-23
                 */
                if (clasz.getName().startsWith("com.alibaba.fastjson.")) {
                    continue;
                }

                Field[] fields = clasz.getDeclaredFields();
                for (Field field : fields) {
                    //log.debug(">>1 "+clasz.getSimpleName()+"."+field.getName()+" "+field.getType());

                    // 子类属性已被读取，不再读取同名父属性
                    if(fieldNameSet.contains(field.getName())){
                        continue;
                    }
                    if (Modifier.isTransient(field.getModifiers()) || Modifier.isStatic(field.getModifiers())) {
                        continue;
                    }
                    boolean isAccessible = field.isAccessible();
                    if (!isAccessible) {
                        field.setAccessible(true);
                    }

                    Object val = in.readObject();
                    //log.debug(">>1 " + clasz.getSimpleName() + "." + field.getName() + " " + field.getType() + " " + val);

                    field.set(list, val);
                    field.setAccessible(isAccessible);

                    // 记录已记取的属性
                    fieldNameSet.add(field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            throw new IOException(e.getMessage());
        }
        fieldNameSet.clear();
        /** end **/


        while (!in.isEnd())
            list.add(in.readObject());

        in.readEnd();

        return list;
    }

    public Object readLengthList(AbstractHessianInput in, int length)
            throws IOException {
        Collection list = createList();

        in.addRef(list);

        /**
         * 修改序列化过程中导致属性丢失的bug：对继承自Collection并扩展了新属性的类，对其新增属性反序列化。
         *
         * Added By HuQingmiao(443770574@qq.com) on 2017-03-25.
         */
        /** begin **/
        //记录已经读过的子类属性，以防被同名父类属性覆盖
        Set<String> fieldNameSet = new HashSet<String>();
        try {
            Class clasz = list.getClass();

            // 不处理java库本身的collection类，只处理自定义的collection类
            for (; !clasz.getName().startsWith("java."); clasz = clasz.getSuperclass()) {

                /**
                 * 通常认为只有Collection的子类才会进入本类反序列化, 但是com.alibaba.fastjson.JSONArray也进入本类反序列化, 虽然它不是Collection的子类,
                 * 因此必须将其排除, 使其按照fastjson本身的机制序列化.  _2017-08-23
                 */
                if (clasz.getName().startsWith("com.alibaba.fastjson.")) {
                    continue;
                }

                Field[] fields = clasz.getDeclaredFields();
                for (Field field : fields) {
                    //log.debug(">>2 " + clasz.getSimpleName() + "." + field.getName() + " " + field.getType());

                    // 子类属性已被读取，不再读取同名父属性
                    if(fieldNameSet.contains(field.getName())){
                        continue;
                    }
                    if (Modifier.isTransient(field.getModifiers()) || Modifier.isStatic(field.getModifiers())) {
                        continue;
                    }
                    boolean isAccessible = field.isAccessible();
                    if (!isAccessible) {
                        field.setAccessible(true);
                    }

                    Object val = in.readObject();
                    //log.debug(">>2 " + clasz.getSimpleName() + "." + field.getName() + " " + field.getType() + " " + val);

                    field.set(list, val);
                    field.setAccessible(isAccessible);

                    // 记录已记取的属性
                    fieldNameSet.add(field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            throw new IOException(e.getMessage());
        }
        fieldNameSet.clear();
        /** end **/

        for (; length > 0; length--)
            list.add(in.readObject());

        return list;
    }

    private Collection createList()
            throws IOException {
        Collection list = null;

        if (_type == null)
            list = new ArrayList();
        else if (!_type.isInterface()) {
            try {
                list = (Collection) _type.newInstance();
            } catch (Exception e) {
            }
        }

        if (list != null) {
        } else if (SortedSet.class.isAssignableFrom(_type))
            list = new TreeSet();
        else if (Set.class.isAssignableFrom(_type))
            list = new HashSet();
        else if (List.class.isAssignableFrom(_type))
            list = new ArrayList();
        else if (Collection.class.isAssignableFrom(_type))
            list = new ArrayList();
        else {
            try {
                list = (Collection) _type.newInstance();
            } catch (Exception e) {
                throw new IOExceptionWrapper(e);
            }
        }

        return list;
    }
}


