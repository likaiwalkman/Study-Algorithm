package xmlUnmarshal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class PojoMapConverter implements Converter {

    public PojoMapConverter() {
        super();
    }

    public boolean canConvert(Class clazz) {
        String classname = clazz.getName();
        if (classname.indexOf("Map") >= 0
                || classname.indexOf("List") >= 0
                || classname.indexOf("Bean") >= 0)
            return true;
        else
            return false;
    }

    public void marshal(Object value, HierarchicalStreamWriter writer,
                        MarshallingContext context) {

        map2xml(value, writer, context);
    }

    protected void map2xml(Object value, HierarchicalStreamWriter writer,
                           MarshallingContext context) {
        boolean bMap = true;
        String classname = value.getClass().getName();

        bMap = (classname.indexOf("List") < 0);
        Map<String, Object> map;
        List<Object> list;
        String key;
        Object subvalue;
        if (bMap) {
            map = (Map<String, Object>) value;
            for (Iterator<Entry<String, Object>> iterator = map.entrySet()
                    .iterator(); iterator.hasNext();) {
                Entry<String, Object> entry = (Entry<String, Object>) iterator
                        .next();
                key = (String) entry.getKey();
                subvalue = entry.getValue();
                writer.startNode(key);
                if (subvalue.getClass().getName().indexOf("String") >= 0) {
                    writer.setValue((String) subvalue);
                } else {
                    map2xml(subvalue, writer, context);
                }
                writer.endNode();
            }

        } else {
            list = (List<Object>) value;
            for (Object subval : list) {
                subvalue = subval;
                writer.startNode("child");
                if (subvalue.getClass().getName().indexOf("String") >= 0) {
                    writer.setValue((String) subvalue);
                } else {
                    map2xml(subvalue, writer, context);
                }
                writer.endNode();
            }
        }
    }

    public Map<String, Object> unmarshal(HierarchicalStreamReader reader,
                                         UnmarshallingContext context) {
        Map<String, Object> map = (Map<String, Object>) populateMap(reader,
                context);
        return map;
    }

    protected Object populateMap(HierarchicalStreamReader reader,
                                 UnmarshallingContext context) {
        boolean bMap = true;
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> list = new ArrayList<Object>();
        while (reader.hasMoreChildren()) {
            reader.moveDown();
            String key = reader.getNodeName();
            Object value = null;
            if (reader.hasMoreChildren()) {
                value = populateMap(reader, context);
            } else {
                value = reader.getValue();
            }
            if (bMap) {
                if (map.containsKey(key)) {
                    // convert to list
                    bMap = false;
                    Iterator<Entry<String, Object>> iter = map.entrySet()
                            .iterator();
                    while (iter.hasNext())
                        list.add(iter.next().getValue());
                    // insert into list
                    list.add(value);
                } else {
                    // insert into map
                    map.put(key, value);
                }
            } else {
                // insert into list
                list.add(value);
            }
            reader.moveUp();
        }
        if (bMap)
            return map;
        else
            return list;
    }

    public static void main(String[] args) {

        String xml = "<map><stars><star><id>1</id><name>littleflower</name></star><star><id>2</id><name>littleyellow</name></star></stars>   <filename>cnlab</filename>   <ra>147.0</ra>   <dec>0.0</dec>   <plate>0.0</plate>   <mdj>0.0</mdj> </map> ";

        xml = "<map>" +
                "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" \n" +
                "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \n" +
                "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
                "\n" +
                "\t<soap:Body>\n" +
                "\t\t<RequestResponse xmlns=\"http://tempuri.org/\">\n" +
                "\t\t\t<RequestResult>\n" +
                "&lt;?xml version=\"1.0\"?&gt;\n" +
                "&lt;Response&gt;\n" +
                "&lt;Header ServerIP=\"10.2.25.194\" ShouldRecordPerformanceTime=\"false\" \n" +
                "UserID=\"100002188\" RequestID=\"18318f7c-dab9-4532-b851-275ab0d932e3\" \n" +
                "ResultCode=\"Success\" AssemblyVersion=\"2.9.5.0\" RequestBodySize=\"0\" \n" +
                "SerializeMode=\"Xml\" RouteStep=\"1\" Environment=\"UAT_NT\" /&gt;\n" +
                "&lt;GetGeographicInfoIncrementResponse&gt;\n" +
                "&lt;Geographics /&gt;\n" +
                "&lt;/GetGeographicInfoIncrementResponse&gt;\n" +
                "&lt;/Response&gt;\n" +
                "\t\t\t</RequestResult>\n" +
                "\t\t</RequestResponse>\n" +
                "\t</soap:Body>\n" +
                "</soap:Envelope></map>";
        XStream xstream = new XStream(new DomDriver());
        xstream.registerConverter(new PojoMapConverter());
        Map<String, Object> map = (Map<String, Object>)xstream.fromXML(xml);
        System.out.println(map);
        xml = xstream.toXML(map);
        System.out.println(xml);
        System.out.println((Map<String, Object>)xstream.fromXML(xml));
    }

}
