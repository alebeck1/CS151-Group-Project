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
//    private ResponseStatus status; - commented out momentarily to prevent errors
    private long responseTimeMs;
    private String errorMessage;
}