import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../../auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(private authService: AuthService,
              private router: Router) { }

  ngOnInit(): void {
  }

  isAuthenticated() {
    return this.authService.profile;
  }

  onLogout() {
    this.authService.postLogout()
      .subscribe(() => this.router.navigate(['/']));
  }
}
