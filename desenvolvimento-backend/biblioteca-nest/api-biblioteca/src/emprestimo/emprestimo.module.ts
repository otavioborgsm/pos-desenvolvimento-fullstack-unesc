import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { EmprestimoEntity } from './entity/emprestimo.entity/emprestimo.entity';
import { EmprestimoController } from './controller/emprestimo.controller/emprestimo.controller';
import { EmprestimoService } from './service/emprestimo.service/emprestimo.service';

@Module({
  imports: [TypeOrmModule.forFeature([EmprestimoEntity])],
  controllers: [EmprestimoController],
  providers: [EmprestimoService],
})
export class EmprestimoModule {}
