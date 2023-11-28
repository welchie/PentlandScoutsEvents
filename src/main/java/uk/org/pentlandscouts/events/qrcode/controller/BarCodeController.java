package uk.org.pentlandscouts.events.qrcode.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import uk.org.pentlandscouts.events.qrcode.QRCodeGenerator;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/barcodes")

public class BarCodeController {

    @Operation(summary = "Generate QR Code with content of {barcode}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content) })
    @GetMapping(value = "/qrcode/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> qrBarcode(@PathVariable("barcode") String barcode)
            throws Exception {
        return okResponse(QRCodeGenerator.generateQRCodeImage(barcode));
    }

    @GetMapping(value = "/qrcode/", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> qrBarcodeURL( @RequestParam(value="url") String url)
            throws Exception {
        return okResponse(QRCodeGenerator.generateQRCodeImage(url));
    }

    @GetMapping(value = "/qrcode/sensordata", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> qrSensorDataBarcode()
            throws Exception {
        String barcode = "http://ec2-34-244-123-50.eu-west-1.compute.amazonaws.com/version/get";
        //barcode = "http://ec2-34-244-123-50.eu-west-1.compute.amazonaws.com/sensordata/findbynameanddatebetween?name=Surface&startdate=2023-11-24%2015%3A00%3A00&enddate=2023-11-24%2019%3A00%3A00";
        barcode = "http://ec2-34-244-123-50.eu-west-1.compute.amazonaws.com/sensordata/findbynameanddatebetween?name=Surface&startdate=2023-11-20%2015%3A00%3A00&enddate=2023-11-20%2019%3A00%3A00";

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
