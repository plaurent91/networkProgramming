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
import org.asnlab.asndt.runtime.value.BitString;

public class PktHeaderAsn {

	@Component(0)
	public Long pktnum;

	@Component(1)
	public Long totpkts;

	@Component(2)
	public BitString typeheaderasn;


	public boolean equals(Object obj) {
		if(!(obj instanceof PktHeaderAsn)){
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

	public static PktHeaderAsn der_decode(InputStream in) throws IOException {
		return (PktHeaderAsn)TYPE.decode(in, EncodingRules.DISTINGUISHED_ENCODING_RULES, CONVERTER);
	}


	public final static AsnType TYPE = DistributedFeatureExtraction.type(65543);

	public final static CompositeConverter CONVERTER;

	static {
		CONVERTER = new AnnotationCompositeConverter(PktHeaderAsn.class);
		AsnConverter pktnumConverter = LongConverter.INSTANCE;
		AsnConverter totpktsConverter = LongConverter.INSTANCE;
		AsnConverter typeheaderasnConverter = BitStringConverter.INSTANCE;
		CONVERTER.setComponentConverters(new AsnConverter[] { pktnumConverter, totpktsConverter, typeheaderasnConverter });
	}


}
