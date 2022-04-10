package world.cup.payload.response;

public class MessageResponseMetier {
	private boolean success;
	private String message;
	private String detail;
	public MessageResponseMetier(boolean success, String message, String detail) {
		super();
		this.success = success;
		this.message = message;
		this.detail = detail;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
