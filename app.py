from flask import Flask, render_template, request
from transformers import pipeline, AutoTokenizer

app = Flask(__name__)

summarizer = pipeline("summarization", model="facebook/bart-large-cnn")
tokenizer = AutoTokenizer.from_pretrained("facebook/bart-large-cnn")

MAX_TOKENS = 1024

@app.route('/', methods=['GET', 'POST'])
def index():
    summary = "" 
    error = ""    
    if request.method == 'POST':
        article = request.form['article']

        if article.strip():  
            tokens = tokenizer(article, return_tensors='pt')['input_ids'][0]

            if len(tokens) > MAX_TOKENS:
                error = f"Error: Input text exceeds the maximum allowed token limit of {MAX_TOKENS}. Please shorten the article."
            else:
                summary_output = summarizer(article, max_length=300, min_length=100, do_sample=False)
                summary = summary_output[0]['summary_text']
    
    return render_template('index.html', summary=summary, error=error)

if __name__ == '__main__':
    app.run(debug=True)
