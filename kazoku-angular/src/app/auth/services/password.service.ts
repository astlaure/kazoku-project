import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ForgotPasswordDto } from '../models/forgot-password.dto';
import { ResetPasswordDto } from '../models/reset-password.dto';

@Injectable({
  providedIn: 'root'
})
export class PasswordService {

  constructor(private httpClient: HttpClient) { }

  postForgotPassword(forgotPassword: ForgotPasswordDto) {
    return this.httpClient.post('api/passwords/forgot', forgotPassword);
  }

  postResetPassword(resetPassword: ResetPasswordDto) {
    return this.httpClient.post('api/passwords/reset', resetPassword);
  }
}
