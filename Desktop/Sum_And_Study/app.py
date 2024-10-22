from flask import Flask, render_template, request
from transformers import pipeline

app = Flask(__name__)

summarizer = pipeline("summarization", model="facebook/bart-large-cnn")

# Quiz answers (you can modify these based on the article's content)
correct_answers = {
    'q1': 'b',
    'q2': 'c'
}

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/summarize', methods=['POST'])
def summarize():
    article = request.form['article']
    summary = summarizer(article, max_length=300, min_length=100, do_sample=False)[0]['summary_text']
    return render_template('index.html', summary=summary)

@app.route('/quiz', methods=['POST'])
def quiz():
    score = 0
    if request.form['q1'] == correct_answers['q1']:
        score += 1
    if request.form['q2'] == correct_answers['q2']:
        score += 1
    
    # Render the result
    return render_template('index.html', score=score)

if __name__ == '__main__':
    app.run(debug=True)
