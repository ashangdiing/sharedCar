package cn.com.august.sharedCar;


public class ResultCode {
	public static enum Result{
		SUCCESS(0), FAIL(1),ERROR(2),ENCODER_ERROR(401),AUTHORIZED_REFUSAL(403),EXCEPTION(404),UNKNOW(-1);
		private int value = 0;
		
		private Result(int value) {
			this.value = value;
		}
		public static Result valueOf(int value) {    //    手写的从int到enum的转换函数
			switch (value) {
			case 0:
				return SUCCESS;
			case 1:
				return FAIL;
			case 2:
				return ERROR;
			case 3:
				return ERROR;
			case 401:
				return ENCODER_ERROR;
			case 403:
				return AUTHORIZED_REFUSAL;
			case 404:
				return EXCEPTION;
			default:
				return UNKNOW;
			}
		}
		public int value() {
			return this.value;
		}
	}
}
