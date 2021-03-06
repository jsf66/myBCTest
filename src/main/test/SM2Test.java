
import org.bouncycastle.util.certificate.*;

import java.io.*;

public class SM2Test {

    public static void main(String[] args) throws Exception {
        String certFilePath = "./src/main/test/sm2certTest.cer";
        byte[] certBytes = InputStream2ByteArray(certFilePath);
        CertInfoTem certInfoTem;
        if(CertParser.isPemParseStyle(certBytes)){
            certInfoTem = new PemCertParser().parseCert(certBytes);
        }else{
            certInfoTem = new DerCertParser().parseCert(certBytes);
        }
        System.out.println(CertParser.getCurCertStyle());
    }
    private static byte[] InputStream2ByteArray(String filePath) throws IOException {

        InputStream in = new FileInputStream(filePath);
        byte[] data = toByteArray(in);
        in.close();

        return data;
    }

    private static byte[] toByteArray(InputStream in) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }
}
