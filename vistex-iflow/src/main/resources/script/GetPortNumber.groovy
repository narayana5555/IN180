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

def void GetPortNumber(Output result, MappingContext context){
	
	
DynamicConfiguration conf = (DynamicConfiguration) container
    .getTransformationParameters()
    .get(StreamTransformationConstants.DYNAMIC_CONFIGURATION);

DynamicConfigurationKey key = DynamicConfigurationKey.create(
   "http:/" + "/sap.com/xi/XI/System/File",
    "Directory");

String directory = conf.get(key);

        int da4Index = directory.indexOf("DA4");
        if (!(da4Index == - 1)) {
						result.addValue("0058005702");
        }

        int qa4Index = directory.indexOf("QA4");
        if (!(qa4Index == - 1)) {
						result.addValue("0058009957");
        }

        int pa4Index = directory.indexOf("PA4");
        if (!(pa4Index == - 1)) {
						result.addValue("0058009957");
        }

}