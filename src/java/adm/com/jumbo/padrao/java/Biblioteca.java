/*
 * The MIT License
 * 
 * Copyright: Copyright (C) 2014 T2Ti.COM
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * The author may be contacted at: t2ti.com@gmail.com
 *
 * @author Claudio de Barros (T2Ti.com)
 * @version 2.0
 */
package adm.com.jumbo.padrao.java;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.Key;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Biblioteca {

    public JFormattedTextField.AbstractFormatter formatoCpf() {
        return new JFormattedTextField.AbstractFormatter() {

            @Override
            public Object stringToValue(String text) throws ParseException {
                String str = text.replace(".", "");
                str = str.replace("-", "");
                return str;
            }

            @Override
            public String valueToString(Object value) throws ParseException {
                String str = (String) value;
                //TODO: implementar código para validação do CPF
                if (str.length() < 11) {
                    return null;
                }
                str = str.replace(".", "");
                str = str.replace("-", "");
                String strFormatado = str.substring(0, 3) + "."
                        + str.substring(3, 6) + "."
                        + str.substring(6, 9) + "-"
                        + str.substring(9, 11);

                return strFormatado;
            }
        };
    }

    public JFormattedTextField.AbstractFormatter formatoCnpj() {
        return new JFormattedTextField.AbstractFormatter() {

            @Override
            public Object stringToValue(String text) throws ParseException {
                String str = text.replace(".", "");
                str = str.replace("-", "");
                str = str.replace("/", "");
                return str;
            }

            @Override
            public String valueToString(Object value) throws ParseException {
                String str = (String) value;
                //TODO: implementar código para validação do CNPJ
                if (str.length() < 14) {
                    return null;
                }
                str = str.replace(".", "");
                str = str.replace("-", "");
                str = str.replace("/", "");
                String strFormatado = str.substring(0, 2) + "."
                        + str.substring(2, 5) + "."
                        + str.substring(5, 8) + "/"
                        + str.substring(8, 12) + "-"
                        + str.substring(12, 14);//10.793.118/0001-78

                return strFormatado;
            }
        };
    }

    public static void copiaArquivo(String origem, String destino) throws Exception {
        FileInputStream in = new FileInputStream(origem);
        FileOutputStream out = new FileOutputStream(destino);
        byte[] bb = new byte[in.available()];
        in.read(bb);
        out.write(bb);
        out.close();
    }

    public static String md5Arquivo(String nomeArquivo) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        File f = new File(nomeArquivo);
        InputStream is = null;
        try {
            is = new FileInputStream(f);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        byte[] buffer = new byte[8192];
        int read = 0;
        try {
            while ((read = is.read(buffer)) > 0) {
                digest.update(buffer, 0, read);
            }
            byte[] md5sum = digest.digest();
            BigInteger bigInt = new BigInteger(1, md5sum);
            String output = bigInt.toString(16);
            return output;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String MD5String(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md;
        md = MessageDigest.getInstance("MD5");
        byte[] md5hash = new byte[32];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        md5hash = md.digest();
        return convertToHex(md5hash);
    }

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    public static byte[] geraAssinaturaArquivo(byte[] arquivoAssinar, File arquivoCertificado, char[] senha) {
        try {
            //Carrega o KeyStore
            KeyStore ks = KeyStore.getInstance("PKCS12");
            InputStream isCertificado = new FileInputStream(arquivoCertificado);
            ks.load(isCertificado, senha);

            //pega a chave privada
            Key key = ks.getKey(ks.aliases().nextElement(), senha);
            PrivateKey privateKey = (PrivateKey) key;

            //cria o objeto Signature infomando o algoritmo de assinatura
            //http://docs.oracle.com/javase/6/docs/technotes/guides/security/StandardNames.html
            Signature sign = Signature.getInstance("SHA1withRSA");
            sign.initSign(privateKey);

            sign.update(arquivoAssinar);

            //gera a assinatura
            byte[] assinatura = sign.sign();

            return assinatura;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Verifica se a data informada e valida
     *
     * @param dia, mes e ano
     * @return true se a data for valida, caso contrario false
     */
    public static boolean validaData(int dia, int mes, int ano) {
        try {
            Calendar dataValidar = Calendar.getInstance();
            dataValidar.setLenient(false);
            dataValidar.set(Calendar.DAY_OF_MONTH, dia);
            dataValidar.set(Calendar.MONTH, mes);
            dataValidar.set(Calendar.YEAR, ano);
            dataValidar.getTime();
            return true;
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return false;
    }

    /**
     * Verifica se a hora informada e valida
     *
     * @param hora, minuto e segundo
     * @return true se a hora for valida, caso contrario false
     */
    public static boolean validaHora(int hora, int minuto, int segundo) {
        try {
            Calendar dataValidar = Calendar.getInstance();
            dataValidar.setLenient(false);
            dataValidar.set(Calendar.HOUR_OF_DAY, hora);
            dataValidar.set(Calendar.MINUTE, minuto);
            dataValidar.set(Calendar.SECOND, segundo);
            dataValidar.getTime();
            return true;
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return false;
    }

    /**
     * Oobtem a hora do dia em segundos
     *
     * @param dataMarcacao
     * @return int - hora do dia em segundos
     */
    public static int getHoraSeg(Calendar dataMarcacao) {
        int segundos = dataMarcacao.get(Calendar.SECOND);
        segundos += dataMarcacao.get(Calendar.MINUTE) * 60;
        segundos += dataMarcacao.get(Calendar.HOUR_OF_DAY) * 3600;
        return segundos;
    }

    /**
     * Converte segundos para horas:minutos:segundos
     *
     * @param segundos
     * @return String no formato HH:mm:ss
     */
    public static String getHoraMinutoSegundo(int segundos) {
        Calendar dataC = Calendar.getInstance();
        dataC.set(Calendar.HOUR_OF_DAY, 0);
        dataC.set(Calendar.MINUTE, 0);
        dataC.set(Calendar.SECOND, 0);

        dataC.add(Calendar.SECOND, segundos);

        String resultado = dataC.get(Calendar.HOUR_OF_DAY) < 10
                ? "0" + dataC.get(Calendar.HOUR_OF_DAY)
                : "" + dataC.get(Calendar.HOUR_OF_DAY);
        resultado += ":";
        resultado += dataC.get(Calendar.MINUTE) < 10
                ? "0" + dataC.get(Calendar.MINUTE)
                : "" + dataC.get(Calendar.MINUTE);
        resultado += ":";
        resultado += dataC.get(Calendar.SECOND) < 10
                ? "0" + dataC.get(Calendar.SECOND)
                : "" + dataC.get(Calendar.SECOND);

        return resultado;
    }

    /**
     * Converte a hora de String para Calendar
     *
     * @param horas no formato HH:mm:ss
     * @return Calendar
     */
    public static Calendar horaStrToCalendar(String horas) {
        Calendar dataC = Calendar.getInstance();
        dataC.set(Calendar.HOUR_OF_DAY, Integer.valueOf(horas.substring(0, 2)));
        dataC.set(Calendar.MINUTE, Integer.valueOf(horas.substring(3, 5)));
        dataC.set(Calendar.SECOND, Integer.valueOf(horas.substring(6, 8)));

        return dataC;
    }

    /**
     * Busca os bytes de um determinado arquivo
     *
     * @param file Arquivo
     * @return byte[]
     */
    public static byte[] getBytesFromFile(File file) throws Exception {
        //converte o arquio em array de bytes
        InputStream is = new FileInputStream(file);
        // Get the size of the file
        long length = file.length();
        // Create the byte array to hold the data
        byte[] documento = new byte[(int) length];
        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < documento.length
                && (numRead = is.read(documento, offset, documento.length - offset)) >= 0) {
            offset += numRead;
        }
        // Ensure all the bytes have been read in
        if (offset < documento.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }
        // Close the input stream and return bytes
        is.close();
        return documento;
    }

    /**
     * Salva um array de byte em um arquivo
     *
     * @param caminhoArquivo Nome do arquivo a ser salvo
     * @param file Array de byte que sera salvo
     *
     */
    public static void salvaArquivo(String caminhoArquivo, byte[] file) throws Exception {
        FileOutputStream out = new FileOutputStream(caminhoArquivo);
        out.write(file);
        out.close();
    }

    /**
     * Verifica se o cnpj informado e valido
     *
     * @param cnpj CNPJ a validar
     * @return boolean
     *
     */
    public static boolean cnpjValido(String cnpj) {
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111")
                || cnpj.equals("22222222222222") || cnpj.equals("33333333333333")
                || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
                || cnpj.equals("66666666666666") || cnpj.equals("77777777777777")
                || cnpj.equals("88888888888888") || cnpj.equals("99999999999999")
                || (cnpj.length() != 14)) {
            return (false);
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                // converte o i-ésimo caractere do CNPJ em um número:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posição de '0' na tabela ASCII)
                num = (cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - r) + 48);
            }

            // Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))) {
                return (true);
            } else {
                return (false);
            }
        } catch (Exception e) {
            return (false);
        }
    }

    public static Object nullToEmpty(Object objeto) {
        Object atributo;
        try {
            Field fields[] = objeto.getClass().getDeclaredFields();
            for (Field f : fields) {

                if (!f.getName().equals("serialVersionUID")) {
                    if (f.getType() == String.class
                            || f.getType() == Integer.class
                            || f.getType() == BigDecimal.class
                            || f.getType() == Double.class
                            || f.getType() == Date.class
                            || f.getType() == Long.class) {

                        Method metodo = objeto.getClass().getDeclaredMethod("get" + primeiraMaiuscula(f.getName()));
                        atributo = metodo.invoke(objeto);
                        if (atributo == null) {
                            if (f.getType() == String.class) {
                                metodo = objeto.getClass().getDeclaredMethod("set" + primeiraMaiuscula(f.getName()), String.class);
                                metodo.invoke(objeto, "");
                            }
                            if (f.getType() == Integer.class) {
                                metodo = objeto.getClass().getDeclaredMethod("set" + primeiraMaiuscula(f.getName()), Integer.class);
                                metodo.invoke(objeto, 0);
                            }
                            if (f.getType() == BigDecimal.class) {
                                metodo = objeto.getClass().getDeclaredMethod("set" + primeiraMaiuscula(f.getName()), BigDecimal.class);
                                metodo.invoke(objeto, BigDecimal.ZERO);
                            }
                            if (f.getType() == Double.class) {
                                metodo = objeto.getClass().getDeclaredMethod("set" + primeiraMaiuscula(f.getName()), Double.class);
                                metodo.invoke(objeto, 0.0);
                            }
                            if (f.getType() == Date.class) {
                                metodo = objeto.getClass().getDeclaredMethod("set" + primeiraMaiuscula(f.getName()), Date.class);
                                metodo.invoke(objeto, new Date(0l));
                            }
                            if (f.getType() == Long.class) {
                                metodo = objeto.getClass().getDeclaredMethod("set" + primeiraMaiuscula(f.getName()), Long.class);
                                metodo.invoke(objeto, 0l);
                            }
                        }
                    } else {
                        System.out.println(f.getName());
                        if (!objeto.getClass().getName().equals(f.getType().getName())) {
                            Method metodo = objeto.getClass().getDeclaredMethod("get" + primeiraMaiuscula(f.getName()));
                            atributo = metodo.invoke(objeto);
                            if (atributo != null) {
                                if (atributo.getClass() == ArrayList.class) {
                                    for (Object o : (Iterable<? extends Object>) atributo) {
                                        //nullToEmpty(o);
                                    }
                                } else {
                                    nullToEmpty(atributo);
                                }
                            } else {
                                if (f.getType() != ArrayList.class || !(f.getType().isArray())) {
                                    metodo = objeto.getClass().getDeclaredMethod("set" + primeiraMaiuscula(f.getName()), f.getType());
                                    metodo.invoke(objeto, Class.forName(f.getType().getName()).newInstance());

                                    metodo = objeto.getClass().getDeclaredMethod("get" + primeiraMaiuscula(f.getName()));
                                    atributo = metodo.invoke(objeto);

                                    nullToEmpty(atributo);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return objeto;
    }

    public static String primeiraMaiuscula(String texto) {
        return Character.toUpperCase(texto.charAt(0)) + texto.substring(1);
    }

    /**
     * Retorna o mes e ano no formato MM/AAAA
     *
     * @param dataA data
     * @return String
     */
    public static String mesAno(Calendar dataA) throws Exception {
        return new SimpleDateFormat("MM/yyyy").format(dataA.getTime());
    }

    public static BigDecimal multiplica(BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado = valor1.multiply(valor2, MathContext.DECIMAL64);
        resultado = resultado.setScale(Constantes.DECIMAIS_VALOR, RoundingMode.DOWN);
        return resultado;
    }

    public static BigDecimal divide(BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado = valor1.divide(valor2, MathContext.DECIMAL64);
        resultado = resultado.setScale(Constantes.DECIMAIS_VALOR, RoundingMode.DOWN);
        return resultado;
    }

    public static BigDecimal subtrai(BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado = valor1.subtract(valor2, MathContext.DECIMAL64);
        resultado = resultado.setScale(Constantes.DECIMAIS_VALOR, RoundingMode.DOWN);
        return resultado;
    }

    public static BigDecimal soma(BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado = valor1.add(valor2, MathContext.DECIMAL64);
        resultado = resultado.setScale(Constantes.DECIMAIS_VALOR, RoundingMode.DOWN);
        return resultado;
    }

    /**
     * Verifica se o cpf informado e valido
     *
     * @param cpf CPF a validar
     * @return boolean
     *
     */
    public static boolean cpfValido(String CPF) {
        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static Integer modulo11(String codigo) {
        int total = 0;
        int peso = 2;

        for (int i = 0; i < codigo.length(); i++) {
            total += (codigo.charAt((codigo.length() - 1) - i) - '0') * peso;
            peso++;
            if (peso == 10) {
                peso = 2;
            }
        }
        int resto = total % 11;
        return (resto == 0 || resto == 1) ? 0 : (11 - resto);
    }

    /**
     * Assina o arquivo XML
     *
     * @param xml conteudo a ser assinado
     * @param alias nome do certificado
     * @param ks Keystore
     * @param senha senha do certificado
     * @param id identificador que sera assinado
     * @param parent elemento pai
     * @return String
     */
    public static String assinaXML(String xml, String alias, KeyStore ks, char[] senha, String id, String parent, String nomeElementoContemId, String nomeAtributoId) throws Exception {
        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

        List<Transform> listTransforms = new ArrayList<>();
        listTransforms.add(fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null));
        listTransforms.add(fac.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (TransformParameterSpec) null));

        Reference ref = fac.newReference(id,
                fac.newDigestMethod(DigestMethod.SHA1, null),
                listTransforms, null, null);
        SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE,
                (C14NMethodParameterSpec) null),
                fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                Collections.singletonList(ref));

        KeyStore.PrivateKeyEntry keyEntry
                = (KeyStore.PrivateKeyEntry) ks.getEntry(alias, new KeyStore.PasswordProtection(senha));
        X509Certificate cert = (X509Certificate) keyEntry.getCertificate();

        KeyInfoFactory kif = fac.getKeyInfoFactory();
        List x509Content = new ArrayList();
        x509Content.add(cert);
        X509Data xd = kif.newX509Data(x509Content);
        KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        Document doc = dbf.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));

        Element element = (Element) doc.getElementsByTagName(nomeElementoContemId).item(0);
        element.setIdAttribute(nomeAtributoId, true);
        
        DOMSignContext dsc = new DOMSignContext(keyEntry.getPrivateKey(), doc.getElementsByTagName(parent).item(0));

        XMLSignature signature = fac.newXMLSignature(si, ki);

        signature.sign(dsc);

        StringWriter writer = new StringWriter();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        trans.transform(new DOMSource(doc), new StreamResult(writer));

        return writer.toString();
    }

}
