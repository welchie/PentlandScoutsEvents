package uk.org.pentlandscouts.events.qrcode.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.org.pentlandscouts.events.qrcode.QRCodeGenerator;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/barcodes")
public class BarCodeController {

    @GetMapping(value = "/qrcode/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> qrBarcode(@PathVariable("barcode") String barcode)
            throws Exception {
        return okResponse(QRCodeGenerator.generateQRCodeImage(barcode));
    }

    private ResponseEntity<BufferedImage> okResponse(BufferedImage image) {
        return new ResponseEntity<>(image, HttpStatus.OK);
    }
    @Bean
    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }

    @GetMapping("hello")
    public String hello()
    {
        return "Hello";
    }
}
