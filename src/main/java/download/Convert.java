package download;

import org.apache.commons.lang.math.NumberUtils;

import java.io.File;

public class Convert {
    public static void main(String[] args) throws Exception {
        String diskBasePath = "/Users/victor/Movies/ts/";
        File base = new File(diskBasePath);
        File[] files = base.listFiles();

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (file.getName().contains(".DS_Store")) {
                continue;
            }

            if (!NumberUtils.isNumber(file.getName())) {
                continue;
            }

            //System.out.println(file.getName());

            File[] children = file.listFiles();
            boolean converted = false;
            for (int j = 0; children != null && children.length > 0 && j < children.length; j++) {
                boolean b = children[j].getName().endsWith(".mp4");
                if (b) {
                    converted = true;
                    break;
                }
            }
            if (converted) {
                System.out.println("converted:"+file.getName());
                continue;
            }
            System.out.println("not converted:"+file.getName());
            //convert

            String dir = diskBasePath+file.getName()+"/";
            String cmdTemplate = "ffmpeg -i %sindex.ts -c:v libx264 -c:a aac -threads 16 -preset ultrafast  %s%s.mp4";
            String cmd = String.format(cmdTemplate, dir, dir, file.getName());
            System.out.println(cmd);
            long startTime = System.currentTimeMillis();
            Process p = Runtime.getRuntime().exec(cmd);
            int errorCodeOuter = p.waitFor();
            new File(dir+"index.ts").delete();
            System.out.println(file.getName()+" done code: "+errorCodeOuter+" cost: "+(System.currentTimeMillis() - startTime));
        }
    }
}
