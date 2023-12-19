from django.db import models

class Aluno(models.Model):
    name = models.CharField(max_length=100)
    email = models.CharField(max_length=50)
    matricula = models.CharField(max_length=20)
