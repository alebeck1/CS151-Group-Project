import java.util.Objects;

/**
 * @version 1.0
 * @author Alexander Fleming
 * Represents a response from the LLM
 *
 * the copy/paste from the assignment defines this as a class but the section
 * above it seems to imply it should be an interface??? It's confusing, I should
 * probably ask about it after class.
 * */
public class LLMResponse {
    private String modelName;
    private String text;
    private ResponseStatus status; // Added the enum so it no longer has to be commented out
    private long responseTimeMs;
    private String errorMessage;

    public LLMResponse(String modelName, String text, ResponseStatus status, long responseTimeMs, String errorMessage) {
        this.modelName = modelName;
        this.text = text;
        this.status = status;
        this.responseTimeMs = responseTimeMs;
        this.errorMessage = errorMessage;
    }

    public String getModelName() {
        return modelName;
    }

    public String getText() {
        return text;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public long getResponseTimeMs() {
        return responseTimeMs;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return modelName + " " + text + " " + status + " " + responseTimeMs + " " + errorMessage;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LLMResponse that = (LLMResponse) o;
        if (responseTimeMs != that.responseTimeMs) return false;
        if (modelName != null ? !modelName.equals(that.modelName) : that.modelName != null)
            return false;
        if (text != null ? !text.equals(that.text) : that.text != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null)
            return false;
        if (errorMessage != null ? !errorMessage.equals(that.errorMessage) : that.errorMessage != null)
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        return Objects.hash(modelName, text, status, responseTimeMs, errorMessage);
    }
}