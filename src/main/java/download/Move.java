package download;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Move {
    public static void main(String[] args) throws Exception {
        String diskBasePath = "/Users/victor/Movies/ts/";
        File base = new File(diskBasePath);
        File[] files = base.listFiles();

        for (int i = 0; i < files.length; i++) {
            File fileNoFile = files[i];
            String fileNoFileName = fileNoFile.getName();
            if (fileNoFileName.contains(".DS_Store")) {
                continue;
            }

            File[] children = fileNoFile.listFiles();
            boolean mp4Found = false;
            for (int j = 0; children != null && children.length > 0 && j < children.length; j++) {
                boolean b = children[j].getName().endsWith(".mp4");
                if (b) {
                    mp4Found = true;
                    break;
                }
            }
            if (mp4Found) {
                String originalMp4FileName = diskBasePath+fileNoFileName+"/"+fileNoFileName+".mp4";
                String targetMp4FileName = diskBasePath+fileNoFileName+".mp4";

                if (!new File(targetMp4FileName).exists() && new File(originalMp4FileName).exists()) {
                    Files.move(Paths.get(originalMp4FileName), Paths.get(targetMp4FileName));
                }
                //System.out.println(originalMp4FileName + " " + new File(originalMp4FileName).exists() );

            }
        }


    }
}
