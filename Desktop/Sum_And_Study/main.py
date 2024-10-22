import requests
from transformers import pipeline

API_URL = "https://api-inference.huggingface.co/models/facebook/bart-large-cnn"
headers = {"Authorization": "Bearer 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"}

summarizer = pipeline("summarization", model="facebook/bart-large-cnn")

with open("article.txt", "r") as f:
    ARTICLE = f.read()

summary = summarizer(ARTICLE, max_length=300, min_length=100, do_sample=False)

with open("summary_output.txt", "w") as file:
    file.write(summary[0]['summary_text'])

