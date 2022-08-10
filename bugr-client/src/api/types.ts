export enum ApiRoutesUsers {
  LOGIN = 'http://localhost:8080/api/v1/users',
}
// REPLACE ABOVE WITH A BASE
export interface UserLogin {
  body: {
    username: string
    password: string
  }
}