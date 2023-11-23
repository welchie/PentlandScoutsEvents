package uk.org.pentlandscouts.events.qrcode;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.util.ObjectUtils.isEmpty;
import org.slf4j.LoggerFactory;

public class QRCodeGeneratorTest {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(QRCodeGeneratorTest.class);
    private static final String BARCODE_TEXT_1 = "1234567890abcedfghijkmnopqrstuvwxy!$^^&*()_+";
    @BeforeAll
    static void setup() {
        log.info("Test");
        log.info("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        log.info("@BeforeEach - executes before each test method in this class");
    }

    @Test
    void testGenerateQRCode() throws Exception {
        BufferedImage qrCodeBufferedImage = QRCodeGenerator.generateQRCodeImage(BARCODE_TEXT_1);

        assertFalse(isEmpty(qrCodeBufferedImage));
        assertEquals(false, isEmpty(qrCodeBufferedImage.getData()));
        log.info("qrCodeBufferedImage: " + qrCodeBufferedImage.getData().toString());


    }
}
