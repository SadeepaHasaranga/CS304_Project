package CS304.Autocarsale.controller;

import CS304.Autocarsale.FileUpload.FileResponse;
import CS304.Autocarsale.FileUpload.FileStorageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/upload")
public class FileController {
    @Autowired
    private FileStorageService fileStorageService;

    // store function
    public ResponseEntity<FileResponse> uploadFile(MultipartFile file, String imgName, String imgCategory, String uploadDir){
        String fileName = fileStorageService.storeFile(file,imgName,uploadDir);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/upload/"+imgCategory+"/")
                .path(fileName)
                .toUriString();

        FileResponse fileResponse = new FileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
        return new ResponseEntity<>(fileResponse, HttpStatus.OK);
    }

    // store multiple files
    public ResponseEntity<List<FileResponse>> uploadMultipleFile(MultipartFile[] files,  String imgCategory, String uploadDir){
        List<FileResponse> list = new ArrayList<>();
        //final int[] number = {1};
        Arrays.asList(files).stream().forEach(file->{
            String imgName= StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            String fileName = fileStorageService.storeFile(file,imgName,uploadDir);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/v1/upload/"+imgCategory+"/")
                    .path(fileName)
                    .toUriString();

            FileResponse fileResponse = new FileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
            list.add(fileResponse);
            //number[0]++;
        });
        return new ResponseEntity<List<FileResponse>>(list, HttpStatus.OK);
    }

    // load function
    public ResponseEntity<Resource> LoadFile(String fileName,String fileDir,HttpServletRequest request){
        Resource resource = fileStorageService.loadFileAsResource(fileName,fileDir);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        }catch(IOException ex) {
            System.out.println("Could not determine fileType");
        }
        if(contentType==null) {
            contentType = "application/octet-stream";
        }
        if(resource==null){
            System.out.print("null");
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .body( null);
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body( resource);
    }

    // mappings
    //upload multiple files
    @PostMapping("/uploadvehicleimages/{vehicleId}")
    public ResponseEntity<List<FileResponse>> uploadProviderDetailImages(@RequestParam("file") MultipartFile[] files,@PathVariable int vehicleId){
        String uploadDir="VehicleImages/"+Integer.toString(vehicleId);
        return uploadMultipleFile(files,uploadDir,uploadDir);
    }

    @GetMapping("/VehicleImages/{vehicleId}")
    public List<String> getProviderDetailImages(@PathVariable int vehicleId, HttpServletRequest request){
        String fileDir="VehicleImages/"+Integer.toString(vehicleId);
        return fileStorageService.getMultipleFiles(fileDir);
    }

    @GetMapping("/VehicleImages/{vehicleId}/{fileName}")
    public ResponseEntity<Resource> getProviderLogo(@PathVariable int vehicleId,@PathVariable String fileName, HttpServletRequest request){
        String fileDir="VehicleImages/"+Integer.toString(vehicleId);
        return LoadFile(fileName,fileDir,request);
    }

    @DeleteMapping("/deletevehicleimage/{vehicleId}/{fileName}")
    public boolean deleteDetailImage(@PathVariable int vehicleId,@PathVariable String fileName){
        String fileDir="VehicleImages/"+Integer.toString(vehicleId)+"/"+fileName;
        return fileStorageService.deleteDetailImage(fileDir);
    }

}
