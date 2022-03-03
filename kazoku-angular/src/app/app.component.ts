import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'kazoku-angular';
  // isLoaded = false;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    // this.authService.getProfile()
    //   .subscribe(() => this.isLoaded = true);
  }
}
