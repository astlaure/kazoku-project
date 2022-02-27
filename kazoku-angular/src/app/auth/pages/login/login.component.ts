import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { AuthService } from '../../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm = this.formBuilder.group({
    username: ['', [Validators.required]],
    password: ['', [Validators.required]],
    'remember-me': [false, []],
  });
  globalErrors = false;

  constructor(private formBuilder: FormBuilder,
              private authService: AuthService,
              private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.globalErrors = false;
    this.authService.postLogin(this.loginForm.value)
      .subscribe({
        next: (value) => {
          this.authService.profile.next(value);
          this.router.navigate(['/dashboard']);
        },
        error: (err) => this.globalErrors = true,
      });
  }
}
