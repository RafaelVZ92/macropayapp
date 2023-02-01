package com.rafaelvelazquez.macropayapp.di

import com.rafaelvelazquez.macropayapp.data.domain.DashboardDomainModel
import com.rafaelvelazquez.macropayapp.data.mapper.DashboardMapper
import com.rafaelvelazquez.macropayapp.data.mapper.Mapper
import com.rafaelvelazquez.macropayapp.data.remote.LoginResponse
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class MapperModule {

    @Binds
    @Reusable
    abstract fun bindsDashboardMapper(dashboardMapper: DashboardMapper):
            Mapper<LoginResponse, DashboardDomainModel>
}