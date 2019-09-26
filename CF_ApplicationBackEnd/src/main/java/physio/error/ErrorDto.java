package physio.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {

	private String error;
	private String uri;

	public ErrorDto() {
	}

	public ErrorDto(String message, String uri) {
		this.error = message;
		this.uri = uri;
	}

	public ErrorDto(Exception e, String uri) {
		this.error = e.getMessage();
		this.uri = uri;
	}

}
