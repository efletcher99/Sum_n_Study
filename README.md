# Sum n Study

Sum n Study is a web-based application built with Flask that enables users to paste text into a textbox for instant summarization. The app leverages the Hugging Face transformers library, specifically the BART model, to create concise summaries of longer text passages.

## Features
 - Text Summarization: Users can paste an article or section of text, and the app will return a summarized version.
 - Error Handling: If the input text exceeds the maximum allowed token limit, the app provides a helpful error message to adjust the input.

## Future Plans
In future updates, Sum n Study will allow users to generate quizzes based on the summarized text. These quizzes will include questions that users can answer and receive feedback on any incorrect responses, making it a more interactive learning tool.

## Development Setup
1. Create virtual environment 'python3 -m venv .venv'
2. Activate virual environment 'source .venv/bin/activate'
4. Intstall necessary libraries 'pip install -r requirements.txt'

## Run the application
1. Run 'python app.py'
2. Open your browser and go to 'http://127.0.0.1:5000' to access Sum n Study.
