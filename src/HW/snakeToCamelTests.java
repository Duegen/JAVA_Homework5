package HW;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class snakeToCamelTests {

@Test
void snakeToCamelAppend() {
	assertEquals("", snakeToCamelAppl.snakeToCamelAppendMethod(null));
	assertEquals("", snakeToCamelAppl.snakeToCamelAppendMethod("   \t"));
	assertEquals("", snakeToCamelAppl.snakeToCamelAppendMethod("   ^6; ;"));
	
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelAppendMethod("asv_fgh_iop"));
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelAppendMethod("_asv_fgh_iop"));
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelAppendMethod("asv_fgh_iop_"));
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelAppendMethod("asv__fgh_iop_"));
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelAppendMethod("asv_ fgh_iop_"));
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelAppendMethod("ASV_FGH_IOP_"));
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelAppendMethod(";?ASV_FGH_IOP_"));
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelAppendMethod("  ?ASV_FGH_IOP_ ,"));
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelAppendMethod("a9sv_fg,h_iop"));
	
	assertNotEquals("asvFghIop", snakeToCamelAppl.snakeToCamelAppendMethod("asv_9fgh"));
}

@Test
void snakeToCamelDelete() {
	assertEquals("", snakeToCamelAppl.snakeToCamelDeleteMethod(null));
	assertEquals("", snakeToCamelAppl.snakeToCamelDeleteMethod("   \t"));
	assertEquals("", snakeToCamelAppl.snakeToCamelDeleteMethod("   ^6; ;"));
	
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelDeleteMethod("asv_fgh_iop"));
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelDeleteMethod("_asv_fgh_iop"));
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelDeleteMethod("asv_fgh_iop_"));
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelDeleteMethod("asv__fgh_iop_"));
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelDeleteMethod("asv_ fgh_iop_"));
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelDeleteMethod("ASV_FGH_IOP_"));
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelDeleteMethod(";?ASV_FGH_IOP_"));
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelDeleteMethod("  ?ASV_FGH_IOP_ ,"));
	assertEquals("asvFghIop", snakeToCamelAppl.snakeToCamelDeleteMethod("a9sv_fg,h_iop"));
	
	assertNotEquals("asvFghIop", snakeToCamelAppl.snakeToCamelDeleteMethod("asv_9fgh"));
}

}
