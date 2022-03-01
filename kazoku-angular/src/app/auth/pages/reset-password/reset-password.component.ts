import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { PasswordService } from '../../services/password.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.scss']
})
export class ResetPasswordComponent implements OnInit {
  resetPasswordForm = this.formBuilder.group({
    token: [],
    password: ['', [Validators.required]],
  });
  globalError = false;

  constructor(private formBuilder: FormBuilder, private passwordService: PasswordService,
              private router: Router) { }

  ngOnInit(): void {
    const urlSearchParams = new URLSearchParams(window.location.search);
    this.resetPasswordForm.get('token')?.setValue(urlSearchParams.get('token') || '');
  }

  onSubmit() {
    this.passwordService.postResetPassword(this.resetPasswordForm.value)
      .subscribe({
        next: (value) => this.router.navigate(['/login']),
        error: () => this.globalError = true,
      });
  }
}
