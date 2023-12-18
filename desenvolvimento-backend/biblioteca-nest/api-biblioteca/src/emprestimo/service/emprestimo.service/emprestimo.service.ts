import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { EmprestimoDto } from 'src/emprestimo/dto/emprestimo.dto/emprestimo.dto';
import { EmprestimoEntity } from 'src/emprestimo/entity/emprestimo.entity/emprestimo.entity';
import { Repository } from 'typeorm';

@Injectable()
export class EmprestimoService {
  constructor(
    @InjectRepository(EmprestimoEntity)
    private emprestimoRepository: Repository<EmprestimoEntity>,
  ) {}

  create(emprestimo: EmprestimoDto): Promise<EmprestimoDto> {
    return this.emprestimoRepository.save(emprestimo);
  }

  findAll(): Promise<EmprestimoDto[]> {
    return this.emprestimoRepository.find();
  }
}
