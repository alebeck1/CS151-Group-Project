public class LLMResponseView implements ModelObserver {
    private final String modelString;

    public LLMResponseView(String modelString) {
        this.modelString = modelString;
    }

    @Override
    public void modelChanged() {

    }
}
