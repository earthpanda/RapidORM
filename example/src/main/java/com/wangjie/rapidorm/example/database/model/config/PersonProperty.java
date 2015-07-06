package com.wangjie.rapidorm.example.database.model.config;

import android.database.Cursor;
import com.wangjie.rapidorm.core.generate.withoutreflection.IModelProperty;
import com.wangjie.rapidorm.core.generate.templates.ModelFieldMapper;

import com.wangjie.rapidorm.example.database.model.Person;

import java.util.List;

// THIS CODE IS GENERATED BY RapidORM, DO NOT EDIT.
/**
* Property of Person
*/
public class PersonProperty implements IModelProperty<Person> {


    public static final ModelFieldMapper id = new ModelFieldMapper(0, "id", "id");
    public static final ModelFieldMapper typeId = new ModelFieldMapper(1, "typeId", "typeId");
    public static final ModelFieldMapper name = new ModelFieldMapper(2, "name", "name");
    public static final ModelFieldMapper age = new ModelFieldMapper(3, "age", "age");
    public static final ModelFieldMapper address = new ModelFieldMapper(4, "address", "address");
    public static final ModelFieldMapper birth = new ModelFieldMapper(5, "birth", "birth");
    public static final ModelFieldMapper student = new ModelFieldMapper(6, "student", "student");

    public PersonProperty() {
    }


    @Override
    public void bindInsertArgs(Person model, List<Object> insertArgs) {
        Integer id = model.getId();
        insertArgs.add(null == id ? null : id);

        Integer typeId = model.getTypeId();
        insertArgs.add(null == typeId ? null : typeId);

        String name = model.getName();
        insertArgs.add(null == name ? null : name);

        Integer age = model.getAge();
        insertArgs.add(null == age ? null : age);

        String address = model.getAddress();
        insertArgs.add(null == address ? null : address);

        Long birth = model.getBirth();
        insertArgs.add(null == birth ? null : birth);

        Boolean student = model.isStudent();
        insertArgs.add(null == student ? null : student ? 1 : 0);

    }

    @Override
    public void bindUpdateArgs(Person model, List<Object> updateArgs) {
        Integer id = model.getId();
        updateArgs.add(null == id ? null : id);

        Integer typeId = model.getTypeId();
        updateArgs.add(null == typeId ? null : typeId);

        String name = model.getName();
        updateArgs.add(null == name ? null : name);

        Integer age = model.getAge();
        updateArgs.add(null == age ? null : age);

        String address = model.getAddress();
        updateArgs.add(null == address ? null : address);

        Long birth = model.getBirth();
        updateArgs.add(null == birth ? null : birth);

        Boolean student = model.isStudent();
        updateArgs.add(null == student ? null : student ? 1 : 0);

    }

    @Override
    public void bindPkArgs(Person model, List<Object> pkArgs) {
        Integer id = model.getId();
        pkArgs.add(null == id ? null : id);

        Integer typeId = model.getTypeId();
        pkArgs.add(null == typeId ? null : typeId);

        String name = model.getName();
        pkArgs.add(null == name ? null : name);

        Integer age = model.getAge();
        pkArgs.add(null == age ? null : age);

        String address = model.getAddress();
        pkArgs.add(null == address ? null : address);

        Long birth = model.getBirth();
        pkArgs.add(null == birth ? null : birth);

        Boolean student = model.isStudent();
        pkArgs.add(null == student ? null : student ? 1 : 0);

    }

    @Override
    public Person parseFromCursor(Cursor cursor) {
        Person model = new Person();
        int index;
        index = cursor.getColumnIndex("id");
        if(-1 != index){
            model.setId(cursor.isNull(index) ? null : (cursor.getInt(index)));
        }

        index = cursor.getColumnIndex("typeId");
        if(-1 != index){
            model.setTypeId(cursor.isNull(index) ? null : (cursor.getInt(index)));
        }

        index = cursor.getColumnIndex("name");
        if(-1 != index){
            model.setName(cursor.isNull(index) ? null : (cursor.getString(index)));
        }

        index = cursor.getColumnIndex("age");
        if(-1 != index){
            model.setAge(cursor.isNull(index) ? null : (cursor.getInt(index)));
        }

        index = cursor.getColumnIndex("address");
        if(-1 != index){
            model.setAddress(cursor.isNull(index) ? null : (cursor.getString(index)));
        }

        index = cursor.getColumnIndex("birth");
        if(-1 != index){
            model.setBirth(cursor.isNull(index) ? null : (cursor.getLong(index)));
        }

        index = cursor.getColumnIndex("student");
        if(-1 != index){
            model.setStudent(cursor.isNull(index) ? null : (cursor.getInt(index) == 1));
        }

        return model;
    }

}
