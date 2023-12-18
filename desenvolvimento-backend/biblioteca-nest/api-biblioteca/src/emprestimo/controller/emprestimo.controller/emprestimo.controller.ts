import { Body, Controller, Get, Post } from '@nestjs/common';
import { EmprestimoDto } from 'src/emprestimo/dto/emprestimo.dto/emprestimo.dto';
import { EmprestimoService } from 'src/emprestimo/service/emprestimo.service/emprestimo.service';

@Controller('emprestimo')
export class EmprestimoController {
  constructor(private emprestimoService: EmprestimoService) {}

  @Post()
  create(@Body() emprestimo: EmprestimoDto): Promise<EmprestimoDto> {
    return this.emprestimoService.create(emprestimo);
  }

  @Get()
  async findAll(): Promise<EmprestimoDto[]> {
    return this.emprestimoService.findAll();
  }
}
