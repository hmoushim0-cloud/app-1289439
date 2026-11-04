package sa.factory.qootsurplusfood128.di

import sa.factory.qootsurplusfood128.data.repository.QootSurplusRepositoryImpl
import sa.factory.qootsurplusfood128.domain.repository.QootSurplusRepository
import sa.factory.qootsurplusfood128.domain.usecase.*
import sa.factory.qootsurplusfood128.hardware.HardwareSensorDriver
import sa.factory.qootsurplusfood128.ui.viewmodel.QootSurplusViewModel

class DiContainer {
    val sensorDriver = HardwareSensorDriver()
    val repository: QootSurplusRepository = QootSurplusRepositoryImpl(sensorDriver)

    val getCatalogUseCase = GetCatalogUseCase(repository)
    val manageCartUseCase = ManageCartUseCase(repository)
    val processCheckoutUseCase = ProcessCheckoutUseCase(repository)
    val observeHardwareTelemetryUseCase = ObserveHardwareTelemetryUseCase(repository)

    fun provideViewModel(): QootSurplusViewModel = QootSurplusViewModel(
        getCatalogUseCase,
        manageCartUseCase,
        processCheckoutUseCase,
        observeHardwareTelemetryUseCase
    )
}
