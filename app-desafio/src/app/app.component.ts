import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private thepage: any = "dialogo-upload";

  constructor(
   private router: Router) { }

  title = 'app-desafio';
  
  openPage(): void {
    console.log("goopenPage('" + this.thepage +  "')");
    // this.router.navigate(this.thepage);
    this.router.navigate(['/dialogo-upload']);
  }
}
