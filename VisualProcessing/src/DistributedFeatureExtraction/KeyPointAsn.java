/*
 * Generated by ASN.1 Java Compiler (http://www.asnlab.org/)
 * From ASN.1 module "DistributedFeatureExtraction"
 */
package DistributedFeatureExtraction;

import java.io.*;
import java.math.*;
import org.asnlab.asndt.runtime.conv.*;
import org.asnlab.asndt.runtime.conv.annotation.*;
import org.asnlab.asndt.runtime.type.AsnType;

public class KeyPointAsn {

	@Component(0)
	public Double angle;

	@Component(1)
	public Long klass;

	@Component(2)
	public Long octave;

	@Component(3)
	public Double x;

	@Component(4)
	public Double y;

	@Component(5)
	public Double response;

	@Component(6)
	public Double size;


	public boolean equals(Object obj) {
		if(!(obj instanceof KeyPointAsn)){
			return false;
		}
		return TYPE.equals(this, obj, CONVERTER);
	}

	public void print(PrintStream out) {
		TYPE.print(this, CONVERTER, out);
	}

	public void der_encode(OutputStream out) throws IOException {
		TYPE.encode(this, EncodingRules.DISTINGUISHED_ENCODING_RULES, CONVERTER, out);
	}

	public static KeyPointAsn der_decode(InputStream in) throws IOException {
		return (KeyPointAsn)TYPE.decode(in, EncodingRules.DISTINGUISHED_ENCODING_RULES, CONVERTER);
	}


	public final static AsnType TYPE = DistributedFeatureExtraction.type(65550);

	public final static CompositeConverter CONVERTER;

	static {
		CONVERTER = new AnnotationCompositeConverter(KeyPointAsn.class);
		AsnConverter angleConverter = DoubleConverter.INSTANCE;
		AsnConverter klassConverter = LongConverter.INSTANCE;
		AsnConverter octaveConverter = LongConverter.INSTANCE;
		AsnConverter xConverter = DoubleConverter.INSTANCE;
		AsnConverter yConverter = DoubleConverter.INSTANCE;
		AsnConverter responseConverter = DoubleConverter.INSTANCE;
		AsnConverter sizeConverter = DoubleConverter.INSTANCE;
		CONVERTER.setComponentConverters(new AsnConverter[] { angleConverter, klassConverter, octaveConverter, xConverter, yConverter, responseConverter, sizeConverter });
	}


}