import { Component, OnInit } from '@angular/core';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FileUploadService } from 'src/app/services/file-upload.service';

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css']
})
export class FileUploadComponent implements OnInit {
  currentFile?: File;
  progress = 0;
  message = '';

  fileName = 'Selecione Arquivo';
  fileInfos?: Observable<any>;

  constructor(private uploadService: FileUploadService) { }

  ngOnInit(): void {
    this.fileInfos = this.uploadService.getFiles();
  }

  selectFile(event: any): void {
    if (event.target.files && event.target.files[0]) {
      const file: File = event.target.files[0];
      this.currentFile = file;
      this.fileName = this.currentFile.name;
    } else {
      this.fileName = 'Selecione Arquivo';
    }
  }

  upload(): void {
    this.progress = 0;
    this.message = "";

    if (this.currentFile) {
      this.uploadService.upload(this.currentFile).subscribe(
        (event: any) => {
          if (event.type === HttpEventType.UploadProgress) {
            this.progress = Math.round(100 * event.loaded / event.total);
          } else if (event instanceof HttpResponse) {
            if  (typeof event.body != "object" ) {
              this.message = event.body.message;
              this.currentFile = undefined;
              // this.progress = 0;
            }
            this.fileInfos = this.uploadService.getFiles();
  
          }
        },
        (err: any) => {
          console.log(this.currentFile);
//err.error && err.error.message
          if (err.status == 202 ) {
            this.message = err.error.message;
           // this.progress = 100;
            this.currentFile = undefined;
            this.progress = 0;
          } else {
            this.progress = 0;
            this.message = 'Erro ao processar envio do arquivo! ' + err.error.message;
          }         
        });
    }
  }
}