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

public class SurfParametersAsn {

	@Component(0)
	public Boolean extended;

	@Component(1)
	public Double hessianthreshold;

	@Component(2)
	public Long noctavelayers;

	@Component(3)
	public Long noctaves;

	@Component(4)
	public Boolean upright;


	public boolean equals(Object obj) {
		if(!(obj instanceof SurfParametersAsn)){
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

	public static SurfParametersAsn der_decode(InputStream in) throws IOException {
		return (SurfParametersAsn)TYPE.decode(in, EncodingRules.DISTINGUISHED_ENCODING_RULES, CONVERTER);
	}


	public final static AsnType TYPE = DistributedFeatureExtraction.type(65552);

	public final static CompositeConverter CONVERTER;

	static {
		CONVERTER = new AnnotationCompositeConverter(SurfParametersAsn.class);
		AsnConverter extendedConverter = BooleanConverter.INSTANCE;
		AsnConverter hessianthresholdConverter = DoubleConverter.INSTANCE;
		AsnConverter noctavelayersConverter = LongConverter.INSTANCE;
		AsnConverter noctavesConverter = LongConverter.INSTANCE;
		AsnConverter uprightConverter = BooleanConverter.INSTANCE;
		CONVERTER.setComponentConverters(new AsnConverter[] { extendedConverter, hessianthresholdConverter, noctavelayersConverter, noctavesConverter, uprightConverter });
	}


}
