/*
 * Generated by ASN.1 Java Compiler (http://www.asnlab.org/)
 * From ASN.1 module "DistributedFeatureExtraction"
 */
package DistributedFeatureExtraction;

import java.util.Vector;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.type.AsnModule;
import org.asnlab.asndt.runtime.conv.*;


public class DistributedFeatureExtraction extends AsnModule {

	public final static DistributedFeatureExtraction instance = new DistributedFeatureExtraction();


	/**
	/* Creates the ASN.1 module.
	/* The ASN.1 module instance is created automatically, clients must not call.
	/* A metadata file named DistributedFeatureExtraction.meta must exist in the same package of this class.
	 **/
	private DistributedFeatureExtraction() {
		super(DistributedFeatureExtraction.class); 
	}


	public static AsnType type(int id) {
		return instance.getType(id);
	}

	public static Object value(int valueId, AsnConverter converter) {
		return instance.getValue(valueId, converter);
	}

	public static Object object(int objectId, AsnConverter converter) {
		return instance.getObject(objectId, converter);
	}

	public static Vector objectSet(int objectSetId, AsnConverter converter) {
		return instance.getObjectSet(objectSetId, converter);
	}


}
