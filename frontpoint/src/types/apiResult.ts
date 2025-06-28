export interface ApiResult<T> {
  statusCode: number;
  error?: {
    error: string;
    details: string;
  };
  data?: T;
}
