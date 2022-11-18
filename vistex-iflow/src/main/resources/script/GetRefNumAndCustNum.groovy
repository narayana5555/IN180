import com.sap.it.api.mapping.*;

/*Add MappingContext parameter to read or set headers and properties
def String customFunc1(String P1,String P2,MappingContext context) {
         String value1 = context.getHeader(P1);
         String value2 = context.getProperty(P2);
         return value1+value2;
}

Add Output parameter to assign the output value.
def void custFunc2(String[] is,String[] ps, Output output, MappingContext context) {
        String value1 = context.getHeader(is[0]);
        String value2 = context.getProperty(ps[0]);
        output.addValue(value1);
        output.addValue(value2);
}*/

def void GetRefNumAndCustNum(String[] refNum,String[] custNum,String[] claimReason, Output result, MappingContext context){


String currentrefNum = refNum[0];
String currentcustNum = custNum[0];
String currentclaimReason = claimReason[0];

if(refNum.length == 1){
result.addValue(refNum[0]);
}

for (int loop=1;loop<refNum.length;loop++){

	if ((!(currentrefNum.equals(refNum[loop]))) || (!(currentcustNum.equals(custNum[loop]))) || (!(currentclaimReason.equals(claimReason[loop])))) {
		result.addValue(refNum[loop-1]);
		result.addValue(ResultList.CC);
		currentrefNum = refNum[loop];
		currentcustNum = custNum[loop];
		currentclaimReason = claimReason[loop];
		if (loop == refNum.length - 1){
		result.addValue(refNum[loop]);
		}
	}
	else{
	currentrefNum = refNum[loop];
	currentcustNum = custNum[loop];
	currentclaimReason = claimReason[loop];
	result.addValue(refNum[loop-1]);
		if (loop == refNum.length - 1){
		result.addValue(refNum[loop]);
		}
	}
} 
}