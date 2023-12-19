from django.shortcuts import render
from rest_framework import viewsets
from rest_framework.permissions import IsAuthenticated
from .serializers import AlunoSerializer
from .models import Aluno

class AlunoViewSet(viewsets.ModelViewSet):
    permission_classes = (IsAuthenticated,)

    serializer_class = AlunoSerializer
    queryset = Aluno.objects.all()

# Create your views here.
