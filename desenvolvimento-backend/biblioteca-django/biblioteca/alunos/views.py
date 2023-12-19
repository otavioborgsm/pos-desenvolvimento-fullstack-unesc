from django.shortcuts import render
from rest_framework import viewsets
from .serializers import AlunoSerializer
from .models import Aluno

class AlunoViewSet(viewsets.ModelViewSet):
    serializer_class = AlunoSerializer
    queryset = Aluno.objects.all()

# Create your views here.
