package cn.com.august.sharedCar;


public class PathStaticVar {
	public static final String USER_PATH = "/user";
	public static final String REFRESH_USER_TOKEN = "/refresh_user_token";
	public static final String GET_USER_TOKEN = "/get_user_token";
	public static final String REQ_IP_MANGER_PATH = "/req_ip_manger";
	public static final String ROLE_PATH = "/role";
	public static final String PERMISSION_PATH = "/permission";
	public static final String ADMIN_PATH = "/admin";
	public static final String STOMP_PATH = "/api";
	public static final String REST_PATH = "/api/rest";
	public static final String SYSLOG_PATH = "/system_log";
	public static final String RECORD_PATH = "/record";
	public static final String WORK_SHEET_PATH = "/work_sheet";
	public static final String DATA_REST_PATH = "/data_rest/api";
	public static class PathAPIName {
		public static final String USER_LOGIN = "/user_login";
		public static final String SOFT_DELETE = "/soft_delete";
		public static final String QUERY_TOTAL_COUNT = "/query_total_count";
		public static final String QUERY_USER_BY_NAME = "/query_user_by_name";
	}
	
 
	public static enum State{
		START_APP(0), STOP_APP(1),UNKNOW(2);
       	private int value = 0;

	    private State(int value) {
	        this.value = value;
	    }
	    public static State valueOf(int value) {    //    手写的从int到enum的转换函数
	        switch (value) {
	        case 0:
	        	return START_APP;
	        case 1:
	            return STOP_APP;
	        case 2:
	            return UNKNOW;
	        default:
	            return UNKNOW;
	        }
	    }
	    public int value() {
	        return this.value;
	    }
	}
	
	
	public static enum LogType{
		Default,OperationAdd,OperationDelete,OperationUpdate,OperationQuery,
		OperationAddRest,OperationDeleteRest,OperationUpdateRest,OperationQueryRest,
		SystemInfo,SystemWarn,SystemError,SystemManager
	}
	
}
