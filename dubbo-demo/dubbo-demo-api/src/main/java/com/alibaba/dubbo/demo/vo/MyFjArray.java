package com.alibaba.dubbo.demo.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.*;

import static com.alibaba.fastjson.JSON.toJSON;

/**
 * Created by huqingmiao on 2017-8-23.
 */
public class MyFjArray implements List<Object>, Cloneable, RandomAccess, Serializable {
        private static final long serialVersionUID = 1L;
        private final List<Object> list;
        protected transient Object relatedArray;
        protected transient Type componentType;

        public MyFjArray() {
        this.list = new ArrayList();
    }

        public MyFjArray(List<Object> list) {
        this.list = list;
    }

        public MyFjArray(int initialCapacity) {
        this.list = new ArrayList(initialCapacity);
    }

    public Object getRelatedArray() {
        return this.relatedArray;
    }

    public void setRelatedArray(Object relatedArray) {
        this.relatedArray = relatedArray;
    }

    public Type getComponentType() {
        return this.componentType;
    }

    public void setComponentType(Type componentType) {
        this.componentType = componentType;
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public boolean contains(Object o) {
        return this.list.contains(o);
    }

    public Iterator<Object> iterator() {
        return this.list.iterator();
    }

    public Object[] toArray() {
        return this.list.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return this.list.toArray(a);
    }

    public boolean add(Object e) {
        return this.list.add(e);
    }

    public MyFjArray fluentAdd(Object e) {
        this.list.add(e);
        return this;
    }

    public boolean remove(Object o) {
        return this.list.remove(o);
    }

    public MyFjArray fluentRemove(Object o) {
        this.list.remove(o);
        return this;
    }

    public boolean containsAll(Collection<?> c) {
        return this.list.containsAll(c);
    }

    public boolean addAll(Collection<? extends Object> c) {
        return this.list.addAll(c);
    }

    public MyFjArray fluentAddAll(Collection<? extends Object> c) {
        this.list.addAll(c);
        return this;
    }

    public boolean addAll(int index, Collection<? extends Object> c) {
        return this.list.addAll(index, c);
    }

    public MyFjArray fluentAddAll(int index, Collection<? extends Object> c) {
        this.list.addAll(index, c);
        return this;
    }

    public boolean removeAll(Collection<?> c) {
        return this.list.removeAll(c);
    }

    public MyFjArray fluentRemoveAll(Collection<?> c) {
        this.list.removeAll(c);
        return this;
    }

    public boolean retainAll(Collection<?> c) {
        return this.list.retainAll(c);
    }

    public MyFjArray fluentRetainAll(Collection<?> c) {
        this.list.retainAll(c);
        return this;
    }

    public void clear() {
        this.list.clear();
    }

    public MyFjArray fluentClear() {
        this.list.clear();
        return this;
    }

    public Object set(int index, Object element) {
        if(index == -1) {
            this.list.add(element);
            return null;
        } else if(this.list.size() > index) {
            return this.list.set(index, element);
        } else {
            for(int i = this.list.size(); i < index; ++i) {
                this.list.add((Object)null);
            }

            this.list.add(element);
            return null;
        }
    }

    public MyFjArray fluentSet(int index, Object element) {
        this.set(index, element);
        return this;
    }

    public void add(int index, Object element) {
        this.list.add(index, element);
    }

    public MyFjArray fluentAdd(int index, Object element) {
        this.list.add(index, element);
        return this;
    }

    public Object remove(int index) {
        return this.list.remove(index);
    }

    public MyFjArray fluentRemove(int index) {
        this.list.remove(index);
        return this;
    }

    public int indexOf(Object o) {
        return this.list.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return this.list.lastIndexOf(o);
    }

    public ListIterator<Object> listIterator() {
        return this.list.listIterator();
    }

    public ListIterator<Object> listIterator(int index) {
        return this.list.listIterator(index);
    }

    public List<Object> subList(int fromIndex, int toIndex) {
        return this.list.subList(fromIndex, toIndex);
    }

    public Object get(int index) {
        return this.list.get(index);
    }


    public MyFjArray getJSONArray(int index) {
        Object value = this.list.get(index);
        return value instanceof MyFjArray?(MyFjArray)value:(MyFjArray)toJSON(value);
    }

    public <T> T getObject(int index, Class<T> clazz) {
        Object obj = this.list.get(index);
        return TypeUtils.castToJavaBean(obj, clazz);
    }

    public Boolean getBoolean(int index) {
        Object value = this.get(index);
        return value == null?null:TypeUtils.castToBoolean(value);
    }

    public boolean getBooleanValue(int index) {
        Object value = this.get(index);
        return value == null?false:TypeUtils.castToBoolean(value).booleanValue();
    }

    public Byte getByte(int index) {
        Object value = this.get(index);
        return TypeUtils.castToByte(value);
    }

    public byte getByteValue(int index) {
        Object value = this.get(index);
        return value == null?0:TypeUtils.castToByte(value).byteValue();
    }

    public Short getShort(int index) {
        Object value = this.get(index);
        return TypeUtils.castToShort(value);
    }

    public short getShortValue(int index) {
        Object value = this.get(index);
        return value == null?0:TypeUtils.castToShort(value).shortValue();
    }

    public Integer getInteger(int index) {
        Object value = this.get(index);
        return TypeUtils.castToInt(value);
    }

    public int getIntValue(int index) {
        Object value = this.get(index);
        return value == null?0:TypeUtils.castToInt(value).intValue();
    }

    public Long getLong(int index) {
        Object value = this.get(index);
        return TypeUtils.castToLong(value);
    }

    public long getLongValue(int index) {
        Object value = this.get(index);
        return value == null?0L:TypeUtils.castToLong(value).longValue();
    }

    public Float getFloat(int index) {
        Object value = this.get(index);
        return TypeUtils.castToFloat(value);
    }

    public float getFloatValue(int index) {
        Object value = this.get(index);
        return value == null?0.0F:TypeUtils.castToFloat(value).floatValue();
    }

    public Double getDouble(int index) {
        Object value = this.get(index);
        return TypeUtils.castToDouble(value);
    }

    public double getDoubleValue(int index) {
        Object value = this.get(index);
        return value == null?0.0D:TypeUtils.castToDouble(value).doubleValue();
    }

    public BigDecimal getBigDecimal(int index) {
        Object value = this.get(index);
        return TypeUtils.castToBigDecimal(value);
    }

    public BigInteger getBigInteger(int index) {
        Object value = this.get(index);
        return TypeUtils.castToBigInteger(value);
    }

    public String getString(int index) {
        Object value = this.get(index);
        return TypeUtils.castToString(value);
    }

    public Date getDate(int index) {
        Object value = this.get(index);
        return TypeUtils.castToDate(value);
    }

    public java.sql.Date getSqlDate(int index) {
        Object value = this.get(index);
        return TypeUtils.castToSqlDate(value);
    }

    public Timestamp getTimestamp(int index) {
        Object value = this.get(index);
        return TypeUtils.castToTimestamp(value);
    }

    public <T> List<T> toJavaList(Class<T> clazz) {
        ArrayList list = new ArrayList(this.size());
        ParserConfig config = ParserConfig.getGlobalInstance();
        Iterator var4 = this.iterator();

        while(var4.hasNext()) {
            Object item = var4.next();
            Object classItem = TypeUtils.cast(item, clazz, config);
            list.add(classItem);
        }

        return list;
    }

    public Object clone() {
        return new JSONArray(new ArrayList(this.list));
    }

    public boolean equals(Object obj) {
        return this.list.equals(obj);
    }

    public int hashCode() {
        return this.list.hashCode();
    }
}
