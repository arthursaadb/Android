package com.saad.maximatechtest.gateway.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.saad.maximatechtest.R
import com.saad.maximatechtest.databinding.FragmentGatewayBinding
import com.saad.maximatechtest.utils.AppConnectivityManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GatewayFragment : Fragment(), GatewayContract.View {
    @Inject lateinit var presenter: GatewayContract.Presenter
    private var _binding: FragmentGatewayBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGatewayBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupGatewayOptionsClick()
    }


    override fun goToClient() {
        view?.findNavController()?.navigate(R.id.action_gatewayFragment_to_dataClientFragment)
    }

    override fun goToRequests() {
    }

    override fun goToSalesSummary() {
    }

    override fun goToTools() {
    }

    override fun showIconWithConnection() {
        binding.iconInternet.setImageResource(R.drawable.ic_maxima_nuvem_conectado)
    }

    override fun showIconWithoutConnection() {
        binding.iconInternet.setImageResource(R.drawable.ic_maxima_nuvem_desconectado)
    }

    override fun onResume() {
        super.onResume()

        presenter.validateConnection()
    }

    private fun setupGatewayOptionsClick() {
        binding.cardClients.setOnClickListener { presenter.onClickCardClients() }
        binding.cardRequests.setOnClickListener { presenter.onClickCardRequest() }
        binding.cardSalesSummary.setOnClickListener { presenter.onClickCardSalesSummary() }
        binding.cardTools.setOnClickListener { presenter.onClickCardTools() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}