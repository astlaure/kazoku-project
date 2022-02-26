export interface ProfileDto {
  id: number;
  name: string;
  username: string;
  role: 'ROLE_USER' | 'ROLE_MANAGER' | 'ROLE_ADMIN';
}
