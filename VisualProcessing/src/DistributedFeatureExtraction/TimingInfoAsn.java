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

public class TimingInfoAsn {

	@Component(0)
	public Long hour;

	@Component(1)
	public Long minute;

	@Component(2)
	public Long second;

	@Component(3)
	public Long millisecond;


	public boolean equals(Object obj) {
		if(!(obj instanceof TimingInfoAsn)){
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

	public static TimingInfoAsn der_decode(InputStream in) throws IOException {
		return (TimingInfoAsn)TYPE.decode(in, EncodingRules.DISTINGUISHED_ENCODING_RULES, CONVERTER);
	}


	public final static AsnType TYPE = DistributedFeatureExtraction.type(65549);

	public final static CompositeConverter CONVERTER;

	static {
		CONVERTER = new AnnotationCompositeConverter(TimingInfoAsn.class);
		AsnConverter hourConverter = LongConverter.INSTANCE;
		AsnConverter minuteConverter = LongConverter.INSTANCE;
		AsnConverter secondConverter = LongConverter.INSTANCE;
		AsnConverter millisecondConverter = LongConverter.INSTANCE;
		CONVERTER.setComponentConverters(new AsnConverter[] { hourConverter, minuteConverter, secondConverter, millisecondConverter });
	}


}
