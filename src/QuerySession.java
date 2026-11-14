import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * @version 1.2
 * @author Alexander Fleming, Aidan Lebeck
 * The Model of the AI program.
 * */
public class QuerySession {
    private String question;
    private Map<String,LLMResponse> responses;
    private List<ModelObserver> observers;

    /**
     * Notifies observers that the model has been updated.
     */
    private void notifyObservers() {
        for (ModelObserver observer : observers) {
            observer.modelChanged();
        }
    }

    /**
     * Constructor
     * Initializes responses HashMap and observers ArrayList.
     */
    public QuerySession() {
        this.responses = new HashMap<>();
        this.observers = new ArrayList<>();
        question = "";
    }

    /**
     * Adds an observer for model updates.
     * @param observer the observer to be added
     */
    public void addObserver(ModelObserver observer) {
        this.observers.add(observer);
    }

    /**
     * Removes an observer from model updates.
     * @param observer the observer to be removed
     */
    public void removeObserver(ModelObserver observer) {
        this.observers.remove(observer);
    }

    /**
     * Gets the currently stored question.
     * @return the current question string
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Gets the response of the given LLM name.
     * @param model the LLM's name
     * @return the response of the LLM
     */
    public LLMResponse getResponse(String model) {
        return responses.get(model);
    }

    /**
     * Gets a copy of the responses HashMap
     * @return a copy of the map
     */
    public Map<String, LLMResponse> getResponses() {
        return new  HashMap<>(responses);
    }

    /**
     * Updates the response of the associated LLM.
     * Notifies the observers of the update.
     * @param model the LLM's name
     * @param response the response of the LLM
     */
    public void updateResponse(String model, LLMResponse response) {
        responses.put(model,response);
        notifyObservers();
    }


    /**
     * Starts the query by initializing all the LLM's responses.
     * Sets the current question to ask.
     * Sets the status of each to WAITING.
     * Notifies the observers of the change.
     * @param question the question to ask the LLMs
     */
    public void startQuery(String question) {
        this.question = question;
        responses.put("Llama", new LLMResponse("Llama", "", ResponseStatus.WAITING,
        0, ""));
        responses.put("Gemma", new LLMResponse("Gemma", "", ResponseStatus.WAITING,
                0, ""));
        responses.put("Qwen", new LLMResponse("Qwen", "", ResponseStatus.WAITING,
                0, ""));

        notifyObservers();
    }
}