from flask import Flask, render_template, request
from transformers import pipeline

# Initialize Flask app
app = Flask(__name__)

# Load the summarizer model
summarizer = pipeline("summarization", model="facebook/bart-large-cnn")

# Main route for the app
@app.route('/', methods=['GET', 'POST'])
def index():
    summary = ""  # Variable to store the summary text
    if request.method == 'POST':
        # Get the article input from the form
        article = request.form['article']

        if article.strip():  # Ensure the article is not empty
            # Perform summarization
            summary_output = summarizer(article, max_length=300, min_length=100, do_sample=False)
            summary = summary_output[0]['summary_text']
    
    # Render the template with the input and output
    return render_template('index.html', summary=summary)

# Run the Flask app
if __name__ == '__main__':
    app.run(debug=True)
