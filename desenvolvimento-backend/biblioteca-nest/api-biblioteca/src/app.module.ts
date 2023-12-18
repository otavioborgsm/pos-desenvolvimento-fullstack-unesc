import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { EmprestimoModule } from './emprestimo/emprestimo.module';

@Module({
  imports: [
    TypeOrmModule.forRoot({
      type: 'postgres',
      url: 'postgresql://postgres:postgresmanager@localhost:5432/biblioteca-nest',
      entities: [__dirname + '/../**/*.entity.js'],
      synchronize: true,
    }),
    EmprestimoModule,
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
