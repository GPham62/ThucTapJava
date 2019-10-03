/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.api.service;

import example.api.conector.sql.ObjectSQLCollections;
import example.api.configuration.Configuration;
import example.api.model.DataResponse;
import static example.api.util.ConfigUtil.convertJsonToObject;
import static example.api.util.ConfigUtil.convertStringObjectToModel;
import static example.api.util.ConfigUtil.dbTypeSQL;
import java.lang.reflect.Method;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author anbq
 */
public class ObjectService {

    private static ObjectService instance = null;

    public synchronized static ObjectService getInstance() {
        if (instance == null) {
            instance = new ObjectService();
        }
        return instance;
    }

    public DataResponse create(String object, String sData) {
        try {
            Object objectClass = convertStringObjectToModel(object);
            Class model = objectClass.getClass();
            objectClass = convertJsonToObject(sData, model);
            return ObjectSQLCollections.getInstance().create(object, objectClass);

        } catch (Exception ex) {
            System.out.println("example.api.service " + ex.toString());
            return new DataResponse("-1", ex.getMessage());
        }
    }

    public DataResponse get(String object, Long id) {
        try {

            Object obj = convertStringObjectToModel(object);
            Class objectClass = obj.getClass();
            return ObjectSQLCollections.getInstance().get(objectClass, id.intValue());

        } catch (Exception ex) {
            System.out.println("example.api.service " + ex.toString());
            return new DataResponse("-1", ex.getMessage());
        }
    }

    public DataResponse getByCondition(String object, String sData) {
        try {

            JSONObject jsonObject = new JSONObject(sData);
            JSONArray keys = jsonObject.names();
            Object objectModel = convertStringObjectToModel(object);
            Class model = objectModel.getClass();
            return ObjectSQLCollections.getInstance().getByCondition(objectModel, keys, model, jsonObject);

        } catch (Exception ex) {
            System.out.println("example.api.service " + ex.toString());
            return new DataResponse("-1", ex.getMessage());
        }
    }

//	public DataResponse getField(String object, Long _id, String fieldname) {
//		try {
//			
//		}
//		catch (Exception ex) {
//			ExceptionsCollection.getInstance().addException(
//					Configuration.SERVICE_NAME,
//					ex.getStackTrace()[0].toString(),
//					ex.toString());
//			return new DataResponse("-1", ex.getMessage());
//		}
//	}
    public DataResponse update(String object, Long id, String sData) {
        try {

            Object objectClass = convertStringObjectToModel(object);
            Class model = objectClass.getClass();
            objectClass = convertJsonToObject(sData, model);
            Method setNameMethod = objectClass.getClass().getMethod("setId", int.class);
            Integer objectID = id != null ? id.intValue() : null;
            setNameMethod.invoke(objectClass, objectID);
            return ObjectSQLCollections.getInstance().update(object, objectClass);

        } catch (Exception ex) {
            System.out.println("example.api.service " + ex.toString());
            return new DataResponse("-1", ex.getMessage());
        }
    }

    public DataResponse delete(String object, String id) {
        try {

            Object objectModel = convertStringObjectToModel(object);
            Class objectClass = objectModel.getClass();
            return ObjectSQLCollections.getInstance().delete(objectClass, Integer.parseInt(id));

        } catch (Exception ex) {
            System.out.println("example.api.service " + ex.toString());
            return new DataResponse("-1", ex.getMessage());
        }
    }

    public DataResponse deleteByCondition(String object, String sData) {
        try {

            JSONObject jsonObject = new JSONObject(sData);
            JSONArray keys = jsonObject.names();
            Object objectClass = convertStringObjectToModel(object);
            Class model = objectClass.getClass();
            return ObjectSQLCollections.getInstance().deleteByCondition(objectClass, keys, model, jsonObject);

        } catch (Exception ex) {
            System.out.println("example.api.service " + ex.toString());
            return new DataResponse("-1", ex.getMessage());
        }
    }

    public DataResponse getList(String object, int numberOfSkip, int numberOfLimit) {
        try {

            Object obj = convertStringObjectToModel(object);
            Class objectClass = obj.getClass();
            return ObjectSQLCollections.getInstance().getList(objectClass, numberOfSkip, numberOfLimit);

        } catch (Exception ex) {
            System.out.println("example.api.service " + ex.toString());
            return new DataResponse("-1", ex.getMessage());
        }
    }
//        public DataResponse getListByField(String object,String fieldname, int numberOfSkip, int numberOfLimit) {
//		try {
//			
//		}
//		catch (Exception ex) {
//			ExceptionsCollection.getInstance().addException(
//					Configuration.SERVICE_NAME,
//					ex.getStackTrace()[0].toString(),
//					ex.toString());
//			return new DataResponse("-1", ex.getMessage());
//		}
//	}

    public DataResponse getListByCondition(String object, String sData, int numberOfSkip, int numberOfLimit) {
        try {

            JSONObject jsonObject = new JSONObject(sData);
            JSONArray keys = jsonObject.names();
            Object obj = convertStringObjectToModel(object);
            Class objectClass = obj.getClass();
            return ObjectSQLCollections.getInstance().getListByCondition(objectClass, keys, jsonObject, numberOfSkip, numberOfLimit);

        } catch (Exception ex) {
            System.out.println("example.api.service " + ex.toString());
            return new DataResponse("-1", ex.getMessage());
        }
    }
//        public DataResponse getListField(String object,Document fieldNames, int numberOfSkip, int numberOfLimit) {
//		try {
//			
//		}
//		catch (Exception ex) {
//			ExceptionsCollection.getInstance().addException(
//					Configuration.SERVICE_NAME,
//					ex.getStackTrace()[0].toString(),
//					ex.toString());
//			return new DataResponse("-1", ex.getMessage());
//		}
//	}
}
